package Chapter14New;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author choijaeyong on 17/08/2019.
 * @project objects
 * @description
 */
public class Call {
  private DateTimeInterval interval;

  public Call(LocalDateTime from, LocalDateTime to) {
    this.interval = DateTimeInterval.of(from,to);
  }

  public Duration getDuration() {
    return interval.duration();
  }

  public LocalDateTime getFrom() {
    return interval.getFrom();
  }

  public LocalDateTime getTo() {
    return interval.getTo();
  }
  public DateTimeInterval getInterval() {
    return interval;
  }

  public List<DateTimeInterval> splitByDay() {
    return interval.splitByDay();
  }
}
