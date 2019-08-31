package Chapter14New;

import java.util.List;

/**
 * @author choijaeyong on 31/08/2019.
 * @project object
 * @description
 */
public interface FeeCondition {
  List<DateTimeInterval> findTimeIntervals(Call call);

}
