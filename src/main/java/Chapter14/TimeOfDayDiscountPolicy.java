package Chapter14;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author choijaeyong on 31/08/2019.
 * @project object
 * @description
 */
public class TimeOfDayDiscountPolicy extends BasicRatePolicy{
  private List<LocalTime> starts = new ArrayList<>();
  private List<LocalTime> ends = new ArrayList<>();
  private List<Duration> durationss = new ArrayList<>();
  private List<Money> amounts = new ArrayList<>();


  @Override
  protected Money calculateCallFee(Call call) {
    Money result = Money.ZERO;
    for(DateTimeInterval interval : call.splitByDay() ) {
      for(int loop = 0 ; loop < starts.size() ; loop++) {
        result.plus(amounts.get(loop).times(
            Duration.between(from(interval, starts.get(loop)) , to(interval, ends.get(loop)))
            .getSeconds() / durationss.get(loop).getSeconds()
        ));
      }
    }
    return result;
  }

  private LocalTime to(DateTimeInterval interval, LocalTime to) {
    return interval.getTo().toLocalTime().isAfter(to) ?
        to :
        interval.getTo().toLocalTime();
  }

  private LocalTime from(DateTimeInterval interval, LocalTime from) {
    return interval.getFrom().toLocalTime().isBefore(from) ?
        from : interval.getFrom().toLocalDate();
  }




}
