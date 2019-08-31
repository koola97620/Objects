package Chapter14New;

import java.time.Duration;

/**
 * @author choijaeyong on 31/08/2019.
 * @project object
 * @description
 */
public class FeePerDuration {
  private Money fee;
  private Duration duration;

  public FeePerDuration(Money fee, Duration duration) {
    this.fee = fee;
    this.duration = duration;
  }

  public Money calculate(DateTimeInterval interval) {
    return fee.times(interval.duration().getSeconds() / duration.getSeconds());

  }
}
