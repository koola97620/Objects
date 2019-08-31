package Chapter14New;

import Chapter14.DurationDiscountRule;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author choijaeyong on 31/08/2019.
 * @project object
 * @description
 */
public class DurationFeeCondition implements FeeCondition {
  private Duration from;
  private Duration to;

  public DurationFeeCondition(Duration from, Duration to) {
    this.from = from;
    this.to = to;
  }

  @Override
  public List<DateTimeInterval> findTimeIntervals(Call call) {
    if (call.getInterval().duration().compareTo(from) < 0 ) {
      return Collections.emptyList();
    }

    return Arrays.asList(DateTimeInterval.of(
        call.getInterval().getFrom().plus(from) ,
        call.getInterval().duration().compareTo(to)  > 0 ?
            call.getInterval().getFrom().plus(to) :
            call.getInterval().getTo()
    ));
  }
}
