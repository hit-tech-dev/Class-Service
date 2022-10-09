package com.hit.classservice.application;

import com.hit.classservice.application.input.Input;
import com.hit.classservice.application.input.category.*;
import com.hit.classservice.application.input.notification.CreateNotificationInput;
import com.hit.classservice.application.input.notification.DeleteNotificationInput;
import com.hit.classservice.application.input.notification.GetNotificationInput;
import com.hit.classservice.application.input.notification.ReadNotificationInput;
import com.hit.classservice.application.input_boundary.UseCase;
import com.hit.classservice.application.interator.category.*;
import com.hit.classservice.application.interator.notification.CreateNotificationInteractor;
import com.hit.classservice.application.interator.notification.DeleteNotificationInteractor;
import com.hit.classservice.application.interator.notification.GetNotificationInteractor;
import com.hit.classservice.application.interator.notification.ReadNotificationInteractor;
import com.hit.classservice.application.output.Output;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component("ApplicationUseCaseBus")
public class UseCaseBus {

    private final HashMap<Class<? extends Input>, Class<? extends UseCase<? extends Input, ? extends Output>>> handlerTypes = new HashMap<>();
    private final HashMap<Class<? extends Input>, UseCaseInvoker> invokers = new HashMap<>();
    private final ApplicationContext applicationContext;

    @Autowired
    public UseCaseBus(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;

        // category
        handlerTypes.put(GetListCategoryInput.class, GetListCategoryInteractor.class);
        handlerTypes.put(GetCategoryInput.class, GetCategoryInteractor.class);
        handlerTypes.put(CreateCategoryInput.class, CreateCategoryInteractor.class);
        handlerTypes.put(UpdateCategoryInput.class, UpdateCategoryInteractor.class);
        handlerTypes.put(DeleteCategoryInput.class, DeleteCategoryInteractor.class);

        // notification
        handlerTypes.put(DeleteNotificationInput.class, DeleteNotificationInteractor.class);
        handlerTypes.put(GetNotificationInput.class, GetNotificationInteractor.class);
        handlerTypes.put(CreateNotificationInput.class, CreateNotificationInteractor.class);
        handlerTypes.put(ReadNotificationInput.class, ReadNotificationInteractor.class);
    }

    public <TInput extends Input, TOutput extends Output> TOutput handle(TInput input)
            throws Exception {
        UseCaseInvoker useCaseInvoker = this.getInvokers(input);
        return useCaseInvoker.invoke(input);
    }

    private <TInput extends Input> UseCaseInvoker getInvokers(TInput input) {
        // 指定input型に対応したhandlerのBeanオブジェクトが取得済みの場合は返却
        if (invokers.containsKey(input.getClass()))
            return invokers.get(input.getClass());

        // 指定input型に対応したhandlerが存在しない場合は例外をスローして処理終了
        // UseCaseクラスのファクトリー処理は実装しない (* SpringBootに一任するため
        if (!handlerTypes.containsKey(input.getClass()))
            throw new RuntimeException(String.format("[%s]. not registerd use case interactor.",
                    input.getClass().toString()));

        // 指定input型に対応したhandlerを所持するUseCaseクラスのBeanオブジェクト取得 (コストが高そうな処理ので一回取得したらシャローコピーしておく
        UseCaseInvoker useCaseInvoker = new UseCaseInvoker(applicationContext, handlerTypes.get(input.getClass()));
        invokers.put(input.getClass(), useCaseInvoker);
        return useCaseInvoker;
    }

}
