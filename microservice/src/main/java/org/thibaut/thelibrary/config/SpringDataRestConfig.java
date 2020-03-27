//package org.thibaut.thelibrary.config;
//
//import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
//import org.springframework.data.rest.core.mapping.ExposureConfiguration;
//import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
//import org.springframework.http.HttpMethod;
//import org.thibaut.thelibrary.entity.LoanEntity;
//
//public class SpringDataRestConfig implements RepositoryRestConfigurer {
//    @Override
//    public void configureRepositoryRestConfiguration( RepositoryRestConfiguration restConfig) {
//    	restConfig.isIdExposedFor( LoanEntity.class );
//    	//To disable some http method
////        ExposureConfiguration config = restConfig.getExposureConfiguration();
////        config.forDomainType(LoanEntity.class).withItemExposure((metadata, httpMethods) -> httpMethods.disable( HttpMethod.PATCH));
//    }
//}
