package Chapter14New;

/**
 * @author choijaeyong on 31/08/2019.
 * @project object
 * @description
 */
public class FeeRule {
  private FeeCondition feeCondition;
  private FeePerDuration feePerDuration;

  public FeeRule(FeeCondition feeCondition, FeePerDuration feePerDuration) {
    this.feeCondition = feeCondition;
    this.feePerDuration = feePerDuration;
  }

  public Money calculateFee(Call call) {
    return feeCondition.findTimeIntervals(call)
            .stream()
            .map(each -> feePerDuration.calculate(each))
            .reduce(Money.ZERO , (first, second) -> first.plus(second));
  }
}
