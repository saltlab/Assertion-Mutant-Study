{"coveredBy":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPartiallyPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]"],"killing":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.ScheduleValidatorTest.testFutureDateTime(ScheduleValidatorTest.java:22)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.ScheduleValidatorTest.testFutureLocalDateTime(ScheduleValidatorTest.java:32)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPartiallyPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.ScheduleValidatorTest.testPartiallyPastLocalDateTime(ScheduleValidatorTest.java:42)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.ScheduleValidatorTest.testCurrentLocalDateTime(ScheduleValidatorTest.java:47)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.ScheduleValidatorTest.testCurrentDateTime(ScheduleValidatorTest.java:52)]"],"mutant":{"filename":"Schedule.java","line":54,"block":4,"id":{"indexes":"[7]","location":{"mdesc":"()Lcom\/urbanairship\/api\/schedule\/model\/Schedule$Builder;","method":"newBuilder","class":"com.urbanairship.api.schedule.model.Schedule"},"mutator":"org.pitest.mutationtest.engine.gregor.mutators.ReturnValsMutator"}}}
{"coveredBy":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPartiallyPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]"],"killing":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:16), com.urbanairship.api.schedule.ScheduleValidatorTest.testFutureDateTime(ScheduleValidatorTest.java:22)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:16), com.urbanairship.api.schedule.ScheduleValidatorTest.testFutureLocalDateTime(ScheduleValidatorTest.java:32)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPartiallyPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:16), com.urbanairship.api.schedule.ScheduleValidatorTest.testPartiallyPastLocalDateTime(ScheduleValidatorTest.java:42)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:16), com.urbanairship.api.schedule.ScheduleValidatorTest.testCurrentLocalDateTime(ScheduleValidatorTest.java:47)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:16), com.urbanairship.api.schedule.ScheduleValidatorTest.testCurrentDateTime(ScheduleValidatorTest.java:52)]"],"mutant":{"filename":"Schedule.java","line":37,"block":2,"id":{"indexes":"[5]","location":{"mdesc":"()Ljava\/lang\/Boolean;","method":"getLocalTimePresent","class":"com.urbanairship.api.schedule.model.Schedule"},"mutator":"org.pitest.mutationtest.engine.gregor.mutators.ReturnValsMutator"}}}
{"coveredBy":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPartiallyPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]"],"killing":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:16), com.urbanairship.api.schedule.ScheduleValidatorTest.testFutureDateTime(ScheduleValidatorTest.java:22)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:24), com.urbanairship.api.schedule.ScheduleValidatorTest.testFutureLocalDateTime(ScheduleValidatorTest.java:32)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPartiallyPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:24), com.urbanairship.api.schedule.ScheduleValidatorTest.testPartiallyPastLocalDateTime(ScheduleValidatorTest.java:42)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:24), com.urbanairship.api.schedule.ScheduleValidatorTest.testCurrentLocalDateTime(ScheduleValidatorTest.java:47)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:16), com.urbanairship.api.schedule.ScheduleValidatorTest.testCurrentDateTime(ScheduleValidatorTest.java:52)]"],"mutant":{"filename":"Schedule.java","line":29,"block":1,"id":{"indexes":"[5]","location":{"mdesc":"()Lorg\/joda\/time\/DateTime;","method":"getScheduledTimestamp","class":"com.urbanairship.api.schedule.model.Schedule"},"mutator":"org.pitest.mutationtest.engine.gregor.mutators.ReturnValsMutator"}}}
{"coveredBy":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPartiallyPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]"],"killing":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:18), com.urbanairship.api.schedule.ScheduleValidatorTest.testFutureDateTime(ScheduleValidatorTest.java:22)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:18), com.urbanairship.api.schedule.ScheduleValidatorTest.testCurrentDateTime(ScheduleValidatorTest.java:52)]"],"mutant":{"filename":"ScheduleValidator.java","line":16,"block":2,"id":{"indexes":"[13]","location":{"mdesc":"(Lcom\/urbanairship\/api\/schedule\/model\/Schedule;)V","method":"validate","class":"com.urbanairship.api.schedule.model.ScheduleValidator"},"mutator":"org.pitest.mutationtest.engine.gregor.mutators.NegateConditionalsMutator"}}}
{"coveredBy":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPartiallyPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]"],"killing":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:26), com.urbanairship.api.schedule.ScheduleValidatorTest.testFutureLocalDateTime(ScheduleValidatorTest.java:32)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPartiallyPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:26), com.urbanairship.api.schedule.ScheduleValidatorTest.testPartiallyPastLocalDateTime(ScheduleValidatorTest.java:42)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:26), com.urbanairship.api.schedule.ScheduleValidatorTest.testCurrentLocalDateTime(ScheduleValidatorTest.java:47)]"],"mutant":{"filename":"ScheduleValidator.java","line":24,"block":6,"id":{"indexes":"[64]","location":{"mdesc":"(Lcom\/urbanairship\/api\/schedule\/model\/Schedule;)V","method":"validate","class":"com.urbanairship.api.schedule.model.ScheduleValidator"},"mutator":"org.pitest.mutationtest.engine.gregor.mutators.NegateConditionalsMutator"}}}
{"coveredBy":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPartiallyPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]"],"killing":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]"],"mutant":{"filename":"ScheduleValidator.java","line":21,"block":4,"id":{"indexes":"[36]","location":{"mdesc":"(Lcom\/urbanairship\/api\/schedule\/model\/Schedule;)V","method":"validate","class":"com.urbanairship.api.schedule.model.ScheduleValidator"},"mutator":"org.pitest.mutationtest.engine.gregor.mutators.NegateConditionalsMutator"}}}
{"coveredBy":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPartiallyPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]"],"killing":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]"],"mutant":{"filename":"ScheduleValidator.java","line":16,"block":1,"id":{"indexes":"[6]","location":{"mdesc":"(Lcom\/urbanairship\/api\/schedule\/model\/Schedule;)V","method":"validate","class":"com.urbanairship.api.schedule.model.ScheduleValidator"},"mutator":"org.pitest.mutationtest.engine.gregor.mutators.NegateConditionalsMutator"}}}
{"coveredBy":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPartiallyPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]"],"killing":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]"],"mutant":{"filename":"ScheduleValidator.java","line":22,"block":8,"id":{"indexes":"[86]","location":{"mdesc":"(Lcom\/urbanairship\/api\/schedule\/model\/Schedule;)V","method":"validate","class":"com.urbanairship.api.schedule.model.ScheduleValidator"},"mutator":"org.pitest.mutationtest.engine.gregor.mutators.NegateConditionalsMutator"}}}
{"coveredBy":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPartiallyPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]"],"killing":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.Schedule$Builder.build(Schedule.java:113), com.urbanairship.api.schedule.ScheduleValidatorTest.testFutureDateTime(ScheduleValidatorTest.java:22)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.Schedule$Builder.build(Schedule.java:113), com.urbanairship.api.schedule.ScheduleValidatorTest.testFutureLocalDateTime(ScheduleValidatorTest.java:32)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPartiallyPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.Schedule$Builder.build(Schedule.java:113), com.urbanairship.api.schedule.ScheduleValidatorTest.testPartiallyPastLocalDateTime(ScheduleValidatorTest.java:42)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.Schedule$Builder.build(Schedule.java:113), com.urbanairship.api.schedule.ScheduleValidatorTest.testCurrentLocalDateTime(ScheduleValidatorTest.java:47)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.Schedule$Builder.build(Schedule.java:113), com.urbanairship.api.schedule.ScheduleValidatorTest.testCurrentDateTime(ScheduleValidatorTest.java:52)]"],"mutant":{"filename":"Schedule.java","line":113,"block":3,"id":{"indexes":"[5]","location":{"mdesc":"()Lcom\/urbanairship\/api\/schedule\/model\/Schedule;","method":"build","class":"com.urbanairship.api.schedule.model.Schedule$Builder"},"mutator":"org.pitest.mutationtest.engine.gregor.mutators.NegateConditionalsMutator"}}}
{"coveredBy":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPartiallyPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]"],"killing":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:16), com.urbanairship.api.schedule.ScheduleValidatorTest.testFutureDateTime(ScheduleValidatorTest.java:22)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:16), com.urbanairship.api.schedule.ScheduleValidatorTest.testFutureLocalDateTime(ScheduleValidatorTest.java:32)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPartiallyPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:16), com.urbanairship.api.schedule.ScheduleValidatorTest.testPartiallyPastLocalDateTime(ScheduleValidatorTest.java:42)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:16), com.urbanairship.api.schedule.ScheduleValidatorTest.testCurrentLocalDateTime(ScheduleValidatorTest.java:47)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.model.ScheduleValidator.validate(ScheduleValidator.java:16), com.urbanairship.api.schedule.ScheduleValidatorTest.testCurrentDateTime(ScheduleValidatorTest.java:52)]"],"mutant":{"filename":"Schedule.java","line":116,"block":5,"id":{"indexes":"[26]","location":{"mdesc":"()Lcom\/urbanairship\/api\/schedule\/model\/Schedule;","method":"build","class":"com.urbanairship.api.schedule.model.Schedule$Builder"},"mutator":"org.pitest.mutationtest.engine.gregor.mutators.ReturnValsMutator"}}}
{"coveredBy":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPartiallyPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]"],"killing":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.ScheduleValidatorTest.testFutureLocalDateTime(ScheduleValidatorTest.java:32)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPartiallyPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.ScheduleValidatorTest.testPartiallyPastLocalDateTime(ScheduleValidatorTest.java:42)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.ScheduleValidatorTest.testCurrentLocalDateTime(ScheduleValidatorTest.java:47)]"],"mutant":{"filename":"Schedule.java","line":105,"block":2,"id":{"indexes":"[15]","location":{"mdesc":"(Lorg\/joda\/time\/DateTime;)Lcom\/urbanairship\/api\/schedule\/model\/Schedule$Builder;","method":"setLocalScheduledTimestamp","class":"com.urbanairship.api.schedule.model.Schedule$Builder"},"mutator":"org.pitest.mutationtest.engine.gregor.mutators.ReturnValsMutator"}}}
{"coveredBy":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]"],"killing":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.ScheduleValidatorTest.testFutureDateTime(ScheduleValidatorTest.java:22)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest), assertion=com.urbanairship.api.schedule.ScheduleValidatorTest.testCurrentDateTime(ScheduleValidatorTest.java:52)]"],"mutant":{"filename":"Schedule.java","line":92,"block":1,"id":{"indexes":"[15]","location":{"mdesc":"(Lorg\/joda\/time\/DateTime;)Lcom\/urbanairship\/api\/schedule\/model\/Schedule$Builder;","method":"setScheduledTimestamp","class":"com.urbanairship.api.schedule.model.Schedule$Builder"},"mutator":"org.pitest.mutationtest.engine.gregor.mutators.ReturnValsMutator"}}}
{"coveredBy":["Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testFutureLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPartiallyPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentLocalDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testPastDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]","Description [testClass=com.urbanairship.api.schedule.ScheduleValidatorTest, name=testCurrentDateTime(com.urbanairship.api.schedule.ScheduleValidatorTest)]"],"killing":[],"mutant":{"filename":"Schedule.java","line":113,"block":5,"id":{"indexes":"[14]","location":{"mdesc":"()Lcom\/urbanairship\/api\/schedule\/model\/Schedule;","method":"build","class":"com.urbanairship.api.schedule.model.Schedule$Builder"},"mutator":"org.pitest.mutationtest.engine.gregor.mutators.VoidMethodCallMutator"}}}
