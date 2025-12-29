package org.kas.demos.Prac.DesignPat.Decorator;

class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(Coffee decoratedCoffee) {
            super(decoratedCoffee);
        }

        @Override
        public String getDescription() {
            return super.getDescription() + ", Milk";
        }

        @Override
        public double getCost() {
            return super.getCost() + 0.5;
        }
    }

    class SugarDecorator extends CoffeeDecorator {
        public SugarDecorator(Coffee decoratedCoffee) {
            super(decoratedCoffee);
        }

        @Override
        public String getDescription() {
            return super.getDescription() + ", Sugar";
        }

        @Override
        public double getCost() {
            return super.getCost() + 0.2;
        }
    }