package nz.ac.auckland.eresearch.projectcentre.validation;

import nz.ac.auckland.eresearch.projectcentre.entity.ExternalReference;
import nz.ac.auckland.eresearch.projectcentre.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ExternalReferenceValidator implements Validator {

  @Autowired
  ValidationUtil validationUtil;
  @Autowired
  DateUtil dateUtil;

  @Override
  public boolean supports(Class<?> clazz) {
    return ExternalReference.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object externalReference, Errors errors) {
    ExternalReference er = (ExternalReference) externalReference;
    String[] notEmpty = {"projectId"};
    new RejectEmptyValidator(ExternalReference.class, notEmpty).validate(externalReference, errors);
    if (!errors.hasErrors()) {
      this.validationUtil.validateProjectId(er.getProjectId(), errors);
    }
    er.setDate(dateUtil.getCurrentDate());
  }

}
