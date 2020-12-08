const stackTrace = {
    "prolog": {
        "description": "ERROR - 13/10/2020 15:46:37 - [main] - com.apicil.batch.runner.job.SmartComplianceBatch (mode : validation_piece) - Error creating bean with name 'liferayParser': Injection of autowired dependencies failed; ",
        "prolog": {
            "description": " org.springframework.beans.factory.BeanCreationException: Could not autowire field: com.apicil.cosy.service.logmonitoring.MonitoringService com.apicil.batch.logMonitoring.Parser.monitoringService; ",
            "prolog": {
                "description": " org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'monitoringService': Injection of autowired dependencies failed; ",
                "prolog": {
                    "description": " org.springframework.beans.factory.BeanCreationException: Could not autowire field: com.apicil.cosy.dao.logmonitoring.IMonitoringOccurrenceDao com.apicil.cosy.service.logmonitoring.MonitoringService.monitoringOccurrenceDao; ",
                    "prolog": {
                        "description": " org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'monitoringOccurrenceDao': Injection of autowired dependencies failed; ",
                        "prolog": {
                            "description": " org.springframework.beans.factory.BeanCreationException: Could not autowire field: org.hibernate.SessionFactory com.apicil.cosy.dao.common.AbstractHibernateDAO.sessionFactory; ",
                            "prolog": {
                                "description": " org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'sessionFactory' defined in class path resource [com/apicil/cosy/service/resources/spring/spring-transactions-wihtoutjta.xml]: Invocation of init method failed; ",
                                "prolog": {
                                    "description": " java.lang.ArrayIndexOutOfBoundsException: 9578?ERROR - 13/10/2020 15:46:37 - [main] - com.apicil.batch.runner.job.SmartComplianceBatch (mode : validation_piece) - Error creating bean with name 'liferayParser': Injection of autowired dependencies failed; ",
                                    "prolog": {
                                        "description": " org.springframework.beans.factory.BeanCreationException: Could not autowire field: com.apicil.cosy.service.logmonitoring.MonitoringService com.apicil.batch.logMonitoring.Parser.monitoringService; ",
                                        "prolog": {
                                            "description": " org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'monitoringService': Injection of autowired dependencies failed; ",
                                            "prolog": {
                                                "description": " org.springframework.beans.factory.BeanCreationException: Could not autowire field: com.apicil.cosy.dao.logmonitoring.IMonitoringOccurrenceDao com.apicil.cosy.service.logmonitoring.MonitoringService.monitoringOccurrenceDao; ",
                                                "prolog": {
                                                    "description": " org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'monitoringOccurrenceDao': Injection of autowired dependencies failed; ",
                                                    "prolog": {
                                                        "description": " org.springframework.beans.factory.BeanCreationException: Could not autowire field: org.hibernate.SessionFactory com.apicil.cosy.dao.common.AbstractHibernateDAO.sessionFactory; ",
                                                        "prolog": {
                                                            "description": " org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'sessionFactory' defined in class path resource [com/apicil/cosy/service/resources/spring/spring-transactions-wihtoutjta.xml]: Invocation of init method failed; ",
                                                            "prolog": {
                                                                "description": " java.lang.ArrayIndexOutOfBoundsException: 9578?org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'liferayParser': Injection of autowired dependencies failed; ",
                                                                "prolog": {
                                                                    "description": " org.springframework.beans.factory.BeanCreationException: Could not autowire field: com.apicil.cosy.service.logmonitoring.MonitoringService com.apicil.batch.logMonitoring.Parser.monitoringService; ",
                                                                    "prolog": {
                                                                        "description": " org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'monitoringService': Injection of autowired dependencies failed; ",
                                                                        "prolog": {
                                                                            "description": " org.springframework.beans.factory.BeanCreationException: Could not autowire field: com.apicil.cosy.dao.logmonitoring.IMonitoringOccurrenceDao com.apicil.cosy.service.logmonitoring.MonitoringService.monitoringOccurrenceDao; ",
                                                                            "prolog": {
                                                                                "description": " org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'monitoringOccurrenceDao': Injection of autowired dependencies failed; ",
                                                                                "prolog": {
                                                                                    "description": " org.springframework.beans.factory.BeanCreationException: Could not autowire field: org.hibernate.SessionFactory com.apicil.cosy.dao.common.AbstractHibernateDAO.sessionFactory; ",
                                                                                    "prolog": {
                                                                                        "description": " org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'sessionFactory' defined in class path resource [com/apicil/cosy/service/resources/spring/spring-transactions-wihtoutjta.xml]: Invocation of init method failed; ",
                                                                                        "prolog": {
                                                                                            "description": " java.lang.ArrayIndexOutOfBoundsException: 9578",
                                                                                            "prolog": null
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    },
    "stackTraceLines": [
        {
            "packageName": "org.springframework.beans.factory.annotation",
            "className": "AutowiredAnnotationBeanPostProcessor",
            "methodName": "postProcessPropertyValues",
            "fileName": "AutowiredAnnotationBeanPostProcessor.java",
            "lineNumber": 287
        },
        {
            "packageName": "org.springframework.beans.factory.support",
            "className": "AbstractAutowireCapableBeanFactory",
            "methodName": "populateBean",
            "fileName": "AbstractAutowireCapableBeanFactory.java",
            "lineNumber": 1073
        },
        {
            "packageName": "org.springframework.beans.factory.support",
            "className": "AbstractAutowireCapableBeanFactory",
            "methodName": "doCreateBean",
            "fileName": "AbstractAutowireCapableBeanFactory.java",
            "lineNumber": 516
        },
        {
            "packageName": "org.springframework.beans.factory.support",
            "className": "AbstractAutowireCapableBeanFactory",
            "methodName": "createBean",
            "fileName": "AbstractAutowireCapableBeanFactory.java",
            "lineNumber": 455
        },
        {
            "packageName": "org.springframework.beans.factory.support",
            "className": "AbstractBeanFactory$1",
            "methodName": "getObject",
            "fileName": "AbstractBeanFactory.java",
            "lineNumber": 293
        },
        {
            "packageName": "org.springframework.beans.factory.support",
            "className": "DefaultSingletonBeanRegistry",
            "methodName": "getSingleton",
            "fileName": "DefaultSingletonBeanRegistry.java",
            "lineNumber": 222
        },
        {
            "packageName": "org.springframework.beans.factory.support",
            "className": "AbstractBeanFactory",
            "methodName": "doGetBean",
            "fileName": "AbstractBeanFactory.java",
            "lineNumber": 290
        },
        {
            "packageName": "org.springframework.beans.factory.support",
            "className": "AbstractBeanFactory",
            "methodName": "getBean",
            "fileName": "AbstractBeanFactory.java",
            "lineNumber": 192
        },
        {
            "packageName": "org.springframework.beans.factory.support",
            "className": "DefaultListableBeanFactory",
            "methodName": "preInstantiateSingletons",
            "fileName": "DefaultListableBeanFactory.java",
            "lineNumber": 585
        },
        {
            "packageName": "org.springframework.context.support",
            "className": "AbstractApplicationContext",
            "methodName": "finishBeanFactoryInitialization",
            "fileName": "AbstractApplicationContext.java",
            "lineNumber": 895
        },
        {
            "packageName": "org.springframework.context.support",
            "className": "AbstractApplicationContext",
            "methodName": "refresh",
            "fileName": "AbstractApplicationContext.java",
            "lineNumber": 425
        },
        {
            "packageName": "com.apicil.batch.runner.job",
            "className": "SmartComplianceBatch",
            "methodName": "execute",
            "fileName": "SmartComplianceBatch.java",
            "lineNumber": 27
        },
        {
            "packageName": "com.apicil.batch.runner",
            "className": "AbstractBatch",
            "methodName": "doNormalExecution",
            "fileName": "AbstractBatch.java",
            "lineNumber": 229
        },
        {
            "packageName": "com.apicil.batch.runner",
            "className": "AbstractBatch",
            "methodName": "tryToExecute",
            "fileName": "AbstractBatch.java",
            "lineNumber": 141
        },
        {
            "packageName": "com.apicil.batch.runner",
            "className": "AbstractBatch",
            "methodName": "executeBatch",
            "fileName": "AbstractBatch.java",
            "lineNumber": 53
        },
        {
            "packageName": "com.apicil.batch.runner",
            "className": "BatchLauncher",
            "methodName": "executerLeBatch",
            "fileName": "BatchLauncher.java",
            "lineNumber": 279
        },
        {
            "packageName": "com.apicil.batch.runner",
            "className": "BatchLauncher",
            "methodName": "main",
            "fileName": "BatchLauncher.java",
            "lineNumber": 160
        }
    ],
    "causedBy": {
        "prolog": {
            "description": ": org.springframework.beans.factory.BeanCreationException: Could not autowire field: com.apicil.cosy.service.logmonitoring.MonitoringService com.apicil.batch.logMonitoring.Parser.monitoringService; ",
            "prolog": {
                "description": " org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'monitoringService': Injection of autowired dependencies failed; ",
                "prolog": {
                    "description": " org.springframework.beans.factory.BeanCreationException: Could not autowire field: com.apicil.cosy.dao.logmonitoring.IMonitoringOccurrenceDao com.apicil.cosy.service.logmonitoring.MonitoringService.monitoringOccurrenceDao; ",
                    "prolog": {
                        "description": " org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'monitoringOccurrenceDao': Injection of autowired dependencies failed; ",
                        "prolog": {
                            "description": " org.springframework.beans.factory.BeanCreationException: Could not autowire field: org.hibernate.SessionFactory com.apicil.cosy.dao.common.AbstractHibernateDAO.sessionFactory; ",
                            "prolog": {
                                "description": " org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'sessionFactory' defined in class path resource [com/apicil/cosy/service/resources/spring/spring-transactions-wihtoutjta.xml]: Invocation of init method failed; ",
                                "prolog": {
                                    "description": " java.lang.ArrayIndexOutOfBoundsException: 9578",
                                    "prolog": null
                                }
                            }
                        }
                    }
                }
            }
        },
        "stackTraceLines": [
            {
                "packageName": "org.springframework.beans.factory.annotation",
                "className": "AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement",
                "methodName": "inject",
                "fileName": "AutowiredAnnotationBeanPostProcessor.java",
                "lineNumber": 506
            },
            {
                "packageName": "org.springframework.beans.factory.annotation",
                "className": "InjectionMetadata",
                "methodName": "inject",
                "fileName": "InjectionMetadata.java",
                "lineNumber": 84
            }
        ],
        "causedBy": {
            "prolog": {
                "description": ": org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'monitoringService': Injection of autowired dependencies failed; ",
                "prolog": {
                    "description": " org.springframework.beans.factory.BeanCreationException: Could not autowire field: com.apicil.cosy.dao.logmonitoring.IMonitoringOccurrenceDao com.apicil.cosy.service.logmonitoring.MonitoringService.monitoringOccurrenceDao; ",
                    "prolog": {
                        "description": " org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'monitoringOccurrenceDao': Injection of autowired dependencies failed; ",
                        "prolog": {
                            "description": " org.springframework.beans.factory.BeanCreationException: Could not autowire field: org.hibernate.SessionFactory com.apicil.cosy.dao.common.AbstractHibernateDAO.sessionFactory; ",
                            "prolog": {
                                "description": " org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'sessionFactory' defined in class path resource [com/apicil/cosy/service/resources/spring/spring-transactions-wihtoutjta.xml]: Invocation of init method failed; ",
                                "prolog": {
                                    "description": " java.lang.ArrayIndexOutOfBoundsException: 9578",
                                    "prolog": null
                                }
                            }
                        }
                    }
                }
            },
            "stackTraceLines": [
                {
                    "packageName": "org.springframework.beans.factory.annotation",
                    "className": "AutowiredAnnotationBeanPostProcessor",
                    "methodName": "postProcessPropertyValues",
                    "fileName": "AutowiredAnnotationBeanPostProcessor.java",
                    "lineNumber": 287
                },
                {
                    "packageName": "org.springframework.beans.factory.support",
                    "className": "AbstractAutowireCapableBeanFactory",
                    "methodName": "populateBean",
                    "fileName": "AbstractAutowireCapableBeanFactory.java",
                    "lineNumber": 1073
                },
                {
                    "packageName": "org.springframework.beans.factory.support",
                    "className": "AbstractAutowireCapableBeanFactory",
                    "methodName": "doCreateBean",
                    "fileName": "AbstractAutowireCapableBeanFactory.java",
                    "lineNumber": 516
                },
                {
                    "packageName": "org.springframework.beans.factory.support",
                    "className": "AbstractAutowireCapableBeanFactory",
                    "methodName": "createBean",
                    "fileName": "AbstractAutowireCapableBeanFactory.java",
                    "lineNumber": 455
                },
                {
                    "packageName": "org.springframework.beans.factory.support",
                    "className": "AbstractBeanFactory$1",
                    "methodName": "getObject",
                    "fileName": "AbstractBeanFactory.java",
                    "lineNumber": 293
                },
                {
                    "packageName": "org.springframework.beans.factory.support",
                    "className": "DefaultSingletonBeanRegistry",
                    "methodName": "getSingleton",
                    "fileName": "DefaultSingletonBeanRegistry.java",
                    "lineNumber": 222
                },
                {
                    "packageName": "org.springframework.beans.factory.support",
                    "className": "AbstractBeanFactory",
                    "methodName": "doGetBean",
                    "fileName": "AbstractBeanFactory.java",
                    "lineNumber": 290
                },
                {
                    "packageName": "org.springframework.beans.factory.support",
                    "className": "AbstractBeanFactory",
                    "methodName": "getBean",
                    "fileName": "AbstractBeanFactory.java",
                    "lineNumber": 192
                },
                {
                    "packageName": "org.springframework.beans.factory.support",
                    "className": "DefaultListableBeanFactory",
                    "methodName": "findAutowireCandidates",
                    "fileName": "DefaultListableBeanFactory.java",
                    "lineNumber": 848
                },
                {
                    "packageName": "org.springframework.beans.factory.support",
                    "className": "DefaultListableBeanFactory",
                    "methodName": "doResolveDependency",
                    "fileName": "DefaultListableBeanFactory.java",
                    "lineNumber": 790
                },
                {
                    "packageName": "org.springframework.beans.factory.support",
                    "className": "DefaultListableBeanFactory",
                    "methodName": "resolveDependency",
                    "fileName": "DefaultListableBeanFactory.java",
                    "lineNumber": 707
                }
            ],
            "causedBy": {
                "prolog": {
                    "description": ": org.springframework.beans.factory.BeanCreationException: Could not autowire field: com.apicil.cosy.dao.logmonitoring.IMonitoringOccurrenceDao com.apicil.cosy.service.logmonitoring.MonitoringService.monitoringOccurrenceDao; ",
                    "prolog": {
                        "description": " org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'monitoringOccurrenceDao': Injection of autowired dependencies failed; ",
                        "prolog": {
                            "description": " org.springframework.beans.factory.BeanCreationException: Could not autowire field: org.hibernate.SessionFactory com.apicil.cosy.dao.common.AbstractHibernateDAO.sessionFactory; ",
                            "prolog": {
                                "description": " org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'sessionFactory' defined in class path resource [com/apicil/cosy/service/resources/spring/spring-transactions-wihtoutjta.xml]: Invocation of init method failed; ",
                                "prolog": {
                                    "description": " java.lang.ArrayIndexOutOfBoundsException: 9578",
                                    "prolog": null
                                }
                            }
                        }
                    }
                },
                "stackTraceLines": [
                    {
                        "packageName": "org.springframework.beans.factory.annotation",
                        "className": "AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement",
                        "methodName": "inject",
                        "fileName": "AutowiredAnnotationBeanPostProcessor.java",
                        "lineNumber": 506
                    },
                    {
                        "packageName": "org.springframework.beans.factory.annotation",
                        "className": "InjectionMetadata",
                        "methodName": "inject",
                        "fileName": "InjectionMetadata.java",
                        "lineNumber": 84
                    }
                ],
                "causedBy": {
                    "prolog": {
                        "description": ": org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'monitoringOccurrenceDao': Injection of autowired dependencies failed; ",
                        "prolog": {
                            "description": " org.springframework.beans.factory.BeanCreationException: Could not autowire field: org.hibernate.SessionFactory com.apicil.cosy.dao.common.AbstractHibernateDAO.sessionFactory; ",
                            "prolog": {
                                "description": " org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'sessionFactory' defined in class path resource [com/apicil/cosy/service/resources/spring/spring-transactions-wihtoutjta.xml]: Invocation of init method failed; ",
                                "prolog": {
                                    "description": " java.lang.ArrayIndexOutOfBoundsException: 9578",
                                    "prolog": null
                                }
                            }
                        }
                    },
                    "stackTraceLines": [],
                    "causedBy": null
                }
            }
        }
    }
}
export default stackTrace;
