package Chapter14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author choijaeyong on 31/08/2019.
 * @project object
 * @description
 */
public class DurationDiscountPolicy extends BasicRatePolicy{
  private List<DurationDiscountRule> rules = new ArrayList<>();

  public DurationDiscountPolicy(List<DurationDiscountRule> rules) {
    this.rules = rules;
  }

  @Override
  protected Money calculateCallFee(Call call) {
    Money result = Money.ZERO;
    for (DurationDiscountRule rule : rules) {
      result.plus(rule.calculate(call));
    }
    return result;
  }
}
