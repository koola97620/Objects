package Chapter14;

/**
 * @author choijaeyong on 18/08/2019.
 * @project objects
 * @description
 */
public interface RatePolicy {
  Money calculateFee(Phone phone);
}
