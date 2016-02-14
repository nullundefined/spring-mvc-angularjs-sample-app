package hr.pbz.sirius.admin.app.controllers;

import hr.pbz.sirius.admin.app.services.MealService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by mcurkovic on 14.02.2016..
 */
@ControllerAdvice
class GlobalControllerExceptionHandler {

  private static final Logger LOGGER = Logger.getLogger(MealService.class);
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  // 500
  @ExceptionHandler(Exception.class)
  public void logError(final Exception ex) {
    LOGGER.error("exception=", ex);
  }
}