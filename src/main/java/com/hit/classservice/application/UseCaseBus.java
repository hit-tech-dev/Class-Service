package com.hit.classservice.application;

import com.hit.classservice.application.input.Input;
import com.hit.classservice.application.input.category.*;
import com.hit.classservice.application.input.comment.*;
import com.hit.classservice.application.input.lesson.*;
import com.hit.classservice.application.input.lesson_student.CreateLessonStudentInput;
import com.hit.classservice.application.input.lesson_student.CreateTicketCheckAttendanceInput;
import com.hit.classservice.application.input.notification.*;
import com.hit.classservice.application.input.role.GetListRoleInput;
import com.hit.classservice.application.input.role.GetRoleInput;
import com.hit.classservice.application.input.role.UpdateRoleInput;
import com.hit.classservice.application.input.schedule.GetListScheduleInput;
import com.hit.classservice.application.input.schedule.GetScheduleByIdInput;
import com.hit.classservice.application.input.schedule.UpdateScheduleInput;
import com.hit.classservice.application.input.subject.*;
import com.hit.classservice.application.input.user_subject.GetListSubjectFromUserInput;
import com.hit.classservice.application.input.user_subject.GetAllLeaderInput;
import com.hit.classservice.application.input.user_subject.GetListUserInSubjectInput;
import com.hit.classservice.application.input.user_subject.RemoveUserFromSubjectInput;
import com.hit.classservice.application.input_boundary.UseCase;
import com.hit.classservice.application.interator.category.*;
import com.hit.classservice.application.interator.comment.*;
import com.hit.classservice.application.interator.lesson.*;
import com.hit.classservice.application.interator.lesson_student.CreateLessonStudentInteractor;
import com.hit.classservice.application.interator.lesson_student.CreateTicketCheckInteractor;
import com.hit.classservice.application.interator.notification.*;
import com.hit.classservice.application.interator.role.GetListRoleInterator;
import com.hit.classservice.application.interator.role.GetRoleInteractor;
import com.hit.classservice.application.interator.role.UpdateRoleInterator;
import com.hit.classservice.application.interator.schedule.GetListScheduleInterator;
import com.hit.classservice.application.interator.schedule.GetScheduleByIdInterator;
import com.hit.classservice.application.interator.schedule.UpdateScheduleInteractor;
import com.hit.classservice.application.interator.subject.*;
import com.hit.classservice.application.interator.user_subject.GetListSubjectFromUserInterator;
import com.hit.classservice.application.interator.user_subject.GetAllLeaderInteractor;
import com.hit.classservice.application.interator.user_subject.GetListUserInSubjectInteractor;
import com.hit.classservice.application.interator.user_subject.RemoveUserFromFromSubjectInteractor;
import com.hit.classservice.application.output.Output;
import com.hit.classservice.application.output.user_subject.GetListSubjectFromUserOutput;
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

    //comment
    handlerTypes.put(GetParentCommentsByLessonInput.class, GetParentCommentsByLessonInteractor.class);
    handlerTypes.put(GetChildrenCommentsByLessonInput.class, GetChildrenCommentsByLessonInteractor.class);
    handlerTypes.put(CreateParentCommentForLessonInput.class, CreateParentCommentForLessonInteractor.class);
    handlerTypes.put(CreateChildrenCommentForLessonInput.class, CreateChildrenCommentForLessonInteractor.class);
    handlerTypes.put(CreateParentCommentForLessonStudentInput.class,
        CreateParentCommentForLessonStudentInteractor.class);
    handlerTypes.put(CreateChildrenCommentForLessonStudentInput.class,
        CreateChildrenCommentForLessonStudentInteractor.class);

    // notification
    handlerTypes.put(DeleteNotificationInput.class, DeleteNotificationInteractor.class);
    handlerTypes.put(GetNotificationInput.class, GetNotificationInteractor.class);
    handlerTypes.put(CreateNotificationInput.class, CreateNotificationInteractor.class);
    handlerTypes.put(ReadNotificationInput.class, ReadNotificationInteractor.class);
    handlerTypes.put(ReadAllNotificationInput.class, ReadAllNotificationInteractor.class);

    //subject
    handlerTypes.put(GetListSubjectInput.class, GetListSubjectInteractor.class);
    handlerTypes.put(GetSubjectInput.class, GetSubjectInteractor.class);
    handlerTypes.put(UpdateSubjectInput.class, UpdateSubjectInteractor.class);
    handlerTypes.put(DeleteSubjectInput.class, DeleteSubjectInteractor.class);
    handlerTypes.put(CreateSubjectInput.class, CreateSubjectInteractor.class);

    // schedule
    handlerTypes.put(GetScheduleByIdInput.class, GetScheduleByIdInterator.class);
    handlerTypes.put(UpdateScheduleInput.class, UpdateScheduleInteractor.class);
    handlerTypes.put(GetListScheduleInput.class, GetListScheduleInterator.class);

    //lesson
    handlerTypes.put(GetListLessonBySubjectIdInput.class, GetListLessonBySubjectIdInteractor.class);
    handlerTypes.put(UpdateLessonInput.class, UpdateLessonInteractor.class);
    handlerTypes.put(CreateLessonInput.class, CreateLessonInteractor.class);
    handlerTypes.put(GetListLessonDetailBySubjectIdInput.class, GetLessonDetailByIdInteractor.class);
    handlerTypes.put(DeleteLessonInput.class, DeleteLessonInteractor.class);

    //role
    handlerTypes.put(UpdateRoleInput.class, UpdateRoleInterator.class);
    handlerTypes.put(GetRoleInput.class, GetRoleInteractor.class);
    handlerTypes.put(GetListRoleInput.class, GetListRoleInterator.class);

    //lesson student
    handlerTypes.put(CreateLessonStudentInput.class, CreateLessonStudentInteractor.class);
    handlerTypes.put(CreateTicketCheckAttendanceInput.class , CreateTicketCheckInteractor.class);

    //user subject
    handlerTypes.put(RemoveUserFromSubjectInput.class, RemoveUserFromFromSubjectInteractor.class);
    handlerTypes.put(GetListSubjectFromUserInput.class, GetListSubjectFromUserInterator.class);
    handlerTypes.put(GetAllLeaderInput.class, GetAllLeaderInteractor.class);
    handlerTypes.put(GetListUserInSubjectInput.class, GetListUserInSubjectInteractor.class);

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
