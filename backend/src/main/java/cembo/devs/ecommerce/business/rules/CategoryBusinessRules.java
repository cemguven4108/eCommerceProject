package cembo.devs.ecommerce.business.rules;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryBusinessRules {

    public void checkIf() {
        log.atInfo().log("Checking something");
    }
}
