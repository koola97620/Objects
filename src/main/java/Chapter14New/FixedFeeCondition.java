package Chapter14New;

import java.util.Arrays;
import java.util.List;

/**
 * @author choijaeyong on 31/08/2019.
 * @project object
 * @description
 */
public class FixedFeeCondition implements FeeCondition{

  @Override
  public List<DateTimeInterval> findTimeIntervals(Call call) {
    return Arrays.asList(call.getInterval());
  }
}
