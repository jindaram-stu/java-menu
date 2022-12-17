package menu.controller;

import java.util.List;
import menu.repository.FoodRepository;
import menu.service.CoachService;
import menu.service.MenuRecommendService;
import menu.service.NotEatFoodService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendController {

    public void run() {
        OutputView.printRun();
        List<String> coachNames = InputView.readCoach();
        addCoach(coachNames);
        addNotEatFoods(coachNames);
        OutputView.printResult(MenuRecommendService.run(), CoachService.findAllCoaches());
    }

    public void addCoach(List<String> coachNames) {
        CoachService.addCoaches(coachNames);
    }

    public void addNotEatFoods(List<String> coachNames) {
        coachNames.stream()
                .forEach(coachName -> NotEatFoodService.addNotEatFoods(InputView.readNotEatFoodByCoach(coachName)));
    }

}
