# springBatch-inflearn

#### 포스팅 바로가기
|                                                    |                                                                                                                         |                                  |
|----------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------|----------------------------------|
| package명                                           | 제목                                                                                                                      | URL                              |
| &#9745;_01_처음_생성해보는_잡                              | 1. Hello Spring Batch!                                                                                                  | https://devfunny.tistory.com/754 |
| &#9745;_02_DB연동                                    | 2. ApplicationRunner 구현 클래스로 Job 수행시키기                                                                                  | https://devfunny.tistory.com/755 |
| &#9745;_03_simpleJobBuilder                        | SpringBatch의 SimpleJob 수행과정을 예제코드 디버깅으로 분석하기                                                                            | https://devfunny.tistory.com/932 |
| &#9745;_04_jobInstance                             | -                                                                                                                       | -                                |
| &#9745;_05_job_수동실행                                | -                                                                                                                       | -                                |
| &#9745;_06_jobParameter                            | 2. ApplicationRunner 구현 클래스로 Job 수행시키기                                                                                  | https://devfunny.tistory.com/755 |
| &#9745;_07_jobExecution                            | 3. Batch Job 수행시 Step 실패하는 경우                                                                                           | https://devfunny.tistory.com/758 |
| &#9745;_08_step                                    | 4. Tasklet 클래스를 생성하여 Job에 설정하기                                                                                          | https://devfunny.tistory.com/759 |
| &#9745;_09_stepExecution                           | 5. Batch Job 수행시 Step 실패하는 경우2 (Step 실패와 StepExceution 관계)                                                              | https://devfunny.tistory.com/765 |
| &#9744;_10_stepContribution                        | -                                                                                                                       | -                                |
| &#9745;_11_executionContext                        | 6. ExecutionContext (StepExecution, JobExecution 관계) 예제로 흐름 파악하기                                                        | https://devfunny.tistory.com/769 |
| &#9745;_12_jobRepository                           | 7. BATCH 테이블 Prefix 변경해보기                                                                                               | https://devfunny.tistory.com/774 |
| &#9745;_12_jobRepository                           | 8. JobRepository 를 사용하여 특정 JobName, JobParameters 에 해당하는 최신에 수행된 Job 정보 가져오기                                            | https://devfunny.tistory.com/769 |
| &#9745;_13_jobLauncher                             | (기존 포스팅) SpringBatch에서 JobLauncher 동기/비동기 실행                                                                            | https://devfunny.tistory.com/688 |
| &#9745;_14_batch_초기화                               | 9. FlowBuilder를 사용해서 FlowJob 생성하기                                                                                       | https://devfunny.tistory.com/776 |
| &#9744;_15_flowJob_실행해보기                           | -                                                                                                                       | -                                |
| &#9745;_16_STEP_종료코드                               | 10. STEP의 EXIT_CODE, STATUS 설정하기                                                                                        | https://devfunny.tistory.com/778 |
| &#9744;_17_stepNext                                | -                                                                                                                       | -                                |
| &#9745;_18_validator                               | 11. JobParameters 검증 CustomValidator 만들기 (JobParametersValidator 구현), 스프링 배치가 제공해주는 DefaultJobParametersValidator 사용해보기 | https://devfunny.tistory.com/779 |
| &#9745;_19_preventRestart-                         | 12. preventRestart() 지정에 따른 수행 과정 파악하기                                                                                  | https://devfunny.tistory.com/786 |
| &#9745;_20_incrementer                             | 13. incrementer 설정하기, JobParametersIncrementer 를 구현하여 커스텀 설정하기                                                          | https://devfunny.tistory.com/790 |
| &#9744;_21_simpleJob_아키텍처                          | -                                                                                                                       | -                                |
| &#9744;_22_StepBuilder                             | -                                                                                                                       | -                                |
| &#9745;_23_taskletStep._tasklet_여러개                | 14. 여러개 Tasklet을 선언할 경우, 마지막 Tasklet을 실행한다                                                                              | https://devfunny.tistory.com/792 |
| &#9745;_24_limit_allow                             | 15. STEP이 COMPELETED 상태로 완료되어도 재실행에 포함시키기 (allowStartIfCompleted(true)), STEP별 재실행 가능 횟수 설정하기 (startLimit())            | https://devfunny.tistory.com/794 |
| &#9745;_25_jobStep                                 | 16. ParentJob, ChildJob 관계 (JobStep 사용)                                                                                 | https://devfunny.tistory.com/798 |
| &#9744;_26_TaskletStep_아키텍처                        | SpringBatch의 TaskletStep 수행과정을 예제코드 디버깅으로 분석하기                                                                          | https://devfunny.tistory.com/934 |
| &#9745;_27_FlowJob                                 | 17. JobFlowBuilder 흐름 제어하기 (Step 성공/실패에 따라 분기처리)                                                                        | https://devfunny.tistory.com/801 |
| &#9745;_28_stepNext_flow                           | 18. Job, Flow 혼용하여 Job 수행시키기                                                                                            | https://devfunny.tistory.com/802 |
| &#9745;_29_BatchStatus_ExitStatus                  | (기존 포스팅) BATCH_JOB_EXECUTION, BATCH_STEP_EXECUTION의 EXIT_CODE, STATUS 컬럼 셋팅 정보                                          | https://devfunny.tistory.com/698 |
| &#9744;_30_transition                              | -                                                                                                                       | -                                |
| &#9745;_31_custom_exitStatus                       | 19. EXIT_CODE를 직접 만들어서 적용해보기                                                                                            | https://devfunny.tistory.com/803 |
| &#9745;_32_decider                                 | 20. JobExecutionDecider 구현체 생성해서 커스텀 값으로 from().on() 설정                                                                 | https://devfunny.tistory.com/805 |
| &#9744;_33_flowJob_아키텍처                            | -                                                                                                                       | -                                |
| &#9744;_34_simpleFlow                              | -                                                                                                                       | -                                |
| &#9744;_35_flowStep                                | -                                                                                                                       | -                                |
| &#9744;_36_jobScope                                | -                                                                                                                       | -                                |
| &#9745;_37_chunk                                   | 21. Chunk 설정에 따른 reader(), processor(), writer() 수행 과정                                                                  | https://devfunny.tistory.com/818 |
| &#9744;_38_ChunkOriented                           | -                                                                                                                       | -                                |
| &#9744;_39_ChunkProvider_ChunkProcessor            | -                                                                                                                       | -                                |
| &#9745;_40_item                                    | 22. ItemReader, ItemProcessor, ItemWriter의 메서드 직접 구현해보기                                                                 | https://devfunny.tistory.com/821 |
| &#9745;_41_itemStream                              | 23. ItemStreamReader, ItemStreamWriter 구현 클래스 생성하기 (open(), update(), close())                                          | https://devfunny.tistory.com/824 |
| &#9745;_42_async                                   | 29. 스프링 배치의 단일 스레드 vs 멀티 스레드 Job 수행하여 분석                                                                                | https://devfunny.tistory.com/831 |
| &#9745;_43_multiThread                             | 30. 스프링 배치 MultiThread(멀티 스레드) Job 수행하여 분석                                                                              | https://devfunny.tistory.com/832 |
| &#9745;_44_parallel                                | 31. 스프링 배치 Parallel Steps(병렬) 수행하여 분석                                                                                   | https://devfunny.tistory.com/833 |
| &#9745;_45_partitioning                            | 32. 스프링 배치 Partitioning(파티셔닝) Job 수행하여 분석                                                                               | https://devfunny.tistory.com/834 |
| &#9745;_46_syncrhnizedItemReader                   | 33. 스프링 배치SynchronizedItemStreamReader로 thread-safe 설정하기                                                                | https://devfunny.tistory.com/835 |
| &#9745;_47_reader_FlatFiles                        | 24. FlatFileItemReader (.csv 파일 읽어와서 데이터 출력하는 배치 생성)                                                                    | https://devfunny.tistory.com/825 |
| &#9744;_48_reader_flatfileDelimete                 | -                                                                                                                       | -                                |
| &#9744;_49_reader_flatfileFixedLength              | -                                                                                                                       | -                                |
| &#9744;_50_reader_flatExceptionHandling            | -                                                                                                                       | -                                |
| &#9745;_51_reader_xml                              | 25. xml 파일 읽어서 출력하는 배치(StaxEventItemReader), josn 파일 읽어서 출력하는 배치(JsonItemReader) 생성해보기                                  | https://devfunny.tistory.com/826 |
| &#9744;_52_reader_json                             | -                                                                                                                       | -                                |
| &#9745;_53_reader_jdbcCursor, _54_reader_jpaCursor | 26. Cursor - JdbcCursorItemReader, JpaCursorItemReader                                                                  | https://devfunny.tistory.com/827 |
| &#9744;_54_reader_jpaCursor                        | -                                                                                                                       | -                                |
| &#9745;_55_reader_jdbcPaging, _56_reader_jpaPaging | 27. Paging - JdbcPagingItemReader, JpaPagingItemReader                                                                  | https://devfunny.tistory.com/828 |
| &#9744;_56_reader_jpaPaging                        | -                                                                                                                       | -                                |
| &#9745;_57_readerAdapter                           | 28. ItemReaderAdapter                                                                                                   | https://devfunny.tistory.com/829 |
| &#9745;_58_writer_json                             | 37. DB 조회한 데이터를 .josn 파일로 생성하는 배치 (JsonFileItemWriter)                                                                  | https://devfunny.tistory.com/847 |
| &#9744;_59_writer_xml                              | -                                                                                                                       | -                                |
| &#9744;_60_writer_jdbcBatch                        | -                                                                                                                       | -                                |
| &#9744;_61_writer_jpa                              | -                                                                                                                       | -                                |
| &#9744;_62_writerAdapter                           | -                                                                                                                       | -                                |
| &#9744;_63_writer_format                           | -                                                                                                                       | -                                |
| &#9744;_64_writer_delimited                        | -                                                                                                                       | -                                |
| &#9744;_65_processor_classifer                     | -                                                                                                                       | -                                |
| &#9745;_66_processor_delegate                      | 36. CustomItemProcessor 여러개를 이어서 수행시키기 (Processor 체이닝)                                                                  | https://devfunny.tistory.com/843 |
| &#9744;_67_repeat                                  | -                                                                                                                       | -                                |
| &#9744;_68_faultTolerant                           | -                                                                                                                       | -                                |
| &#9744;_69_skip                                    | -                                                                                                                       | -                                |
| &#9744;_70_retry                                   | -                                                                                                                       | -                                |
| &#9744;_71_listener_jobAndStep                     | -                                                                                                                       | -                                |
| &#9744;_72_listener_chunk_item                     | -                                                                                                                       | -                                |
| &#9744;_73_listener_step                           | -                                                                                                                       | -                                |
| &#9744;_74_listener_retry                          | -                                                                                                                       | -                                |
| &#9744;_75_listener_skip                           | -                                                                                                                       | -                                |
| &#9745;_77_operation                               | 35. 스프링배치JobExplorer, JobRegistry, JobOperator 알아보기 (With JobRegistryBeanPostProcessor)                                 | https://devfunny.tistory.com/837 |
| &#9745;_78_batch_test                              | 34. 스프링 배치 Test 코드 작성                                                                                                   | https://devfunny.tistory.com/836 |


#### 2차 복습 시작
- 일정 : 2024.01.04(목) 시작
- 과정 : Study 진행 (총 4인)
