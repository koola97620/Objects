package Chapter14New;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author choijaeyong on 18/08/2019.
 * @project objects
 * @description
 */
public abstract class BasicRatePolicy implements RatePolicy {

  private List<FeeRule> feeRules = new ArrayList<>();

  public BasicRatePolicy(FeeRule... feeRules) {
    this.feeRules = Arrays.asList(feeRules);
  }

  @Override
  public Money calculateFee(Phone phone) {
    return phone.getCalls()
            .stream()
            .map(call -> calculate(call))
            .reduce(Money.ZERO , (first, second) -> first.plus(second));
  }

  private Money calculate(Call call) {
    return feeRules.stream()
        .map(rule -> rule.calculateFee(call))
        .reduce(Money.ZERO , (first,second) -> first.plus(second));

  }

  //  @Override
//  public Money calculateFee(Phone phone) {
//    Money result = Money.ZERO;
//    for (Call call : phone.getCalls()) {
//      result.plus(calculateCallFee(call));
//    }
//    return result;
//  }
//
//  protected abstract Money calculateCallFee(Call call);
}
