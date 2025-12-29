package org.kas.demos.Prac.CoderpatQuest.DAY24_27_10;

import java.util.concurrent.CompletableFuture;
    import java.util.concurrent.ExecutionException;
    import java.util.concurrent.TimeUnit;
    import java.util.List;
    import java.util.ArrayList;

    public class AsyncApiCombiner {

        private static CompletableFuture<String> callApi1() {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2); // Simulate API call delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return "Result from API 1";
            });
        }

        private static CompletableFuture<String> callApi2() {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return "Result from API 2";
            });
        }

        private static CompletableFuture<String> callApi3() {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return "Result from API 3";
            });
        }

        private static CompletableFuture<String> callApi4() {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return "Result from API 4";
            });
        }

        private static CompletableFuture<String> callApi5() {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return "Result from API 5";
            });
        }

        public static void main(String[] args) throws ExecutionException, InterruptedException {
            long startTime = System.currentTimeMillis();

            CompletableFuture<String> api1Future = callApi1();
            CompletableFuture<String> api2Future = callApi2();
            CompletableFuture<String> api3Future = callApi3();
            CompletableFuture<String> api4Future = callApi4();
            CompletableFuture<String> api5Future = callApi5();

            // Combine all futures
            CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                    api1Future, api2Future, api3Future, api4Future, api5Future
            );

            // Wait for all futures to complete
            allFutures.join();

            // Retrieve results
            String result1 = api1Future.get();
            String result2 = api2Future.get();
            String result3 = api3Future.get();
            String result4 = api4Future.get();
            String result5 = api5Future.get();

            List<String> combinedResults = new ArrayList<>();
            combinedResults.add(result1);
            combinedResults.add(result2);
            combinedResults.add(result3);
            combinedResults.add(result4);
            combinedResults.add(result5);

            System.out.println("Combined Results: " + combinedResults);

            long endTime = System.currentTimeMillis();
            System.out.println("Total execution time: " + (endTime - startTime) + " ms");
        }
    }