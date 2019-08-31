package Chapter14New;

import Chapter14.Money;
import Chapter14.Phone;

/**
 * @author choijaeyong on 18/08/2019.
 * @project objects
 * @description
 */
public interface RatePolicy {
  Money calculateFee(Phone phone);
}
