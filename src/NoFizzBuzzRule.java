

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Priority;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.annotation.Fact;

@Rule
public class NoFizzBuzzRule {

    @Condition
    public boolean isNotFizzNorBuzz(@Fact("number") Integer number) {
        // can return true, because this is the latest rule to trigger according to assigned priorities
        // and in which case, the number is not fizz nor buzz
        return number % 5 != 0 || number % 7 != 0;
    }

    @Action
    public void printInput(@Fact("number") Integer number) {
        System.out.print(number);
    }

    @Priority
    public int getPriority() {
        return 3;
    }
}