package org.kas.demos.Prac.CoderpatQuest.Day21_16_10.ConnectingTwoDb;

@Service
    public class MyService {

        @Autowired
        private PrimaryRepository primaryRepository;

        @Autowired
        private SecondaryRepository secondaryRepository;

        public void saveDataToPrimaryDb(PrimaryEntity entity) {
            primaryRepository.save(entity);
        }

        public void saveDataToSecondaryDb(SecondaryEntity entity) {
            secondaryRepository.save(entity);
        }
    }