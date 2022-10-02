package com.hit.classservice.application.input_boundary;

import com.hit.classservice.application.input.Input;
import com.hit.classservice.application.output.Output;

public interface UseCase<TInput extends Input, TOutput extends Output> {
  TOutput handle(TInput input) throws Exception;
}
