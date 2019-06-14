package com.example.springbootcache.service;

import com.example.springbootcache.bean.Employee;
import com.example.springbootcache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author jinji.li
 * @email lijinjilijinji@gmail.com
 * @date 2019/6/14
 */
@Service
public class EmployeeService {

    /**
     * cacheNames:缓存组件名称，key：缓存数据使用的key，默认使用方法的参数值[empId],也可以指定
     * keyGenerator:key的生成器，用来指定生成key值，key/keyGenerator二选一使用
     * condition:符合指定条件才缓存
     * unless：否定缓存，unless指定的条件为true，不会缓存方法的返回值
     * sync:是否使用异步模式
     *
     * 缓存原理：
     *1自动配置类:CacheAutoConfiguration
     *2缓存配置类
     * org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration
     *
     * 默认SimpleCacheConfiguration类生效
     * 1SimpleCacheConfiguration向容器中添加ConcurrentMapCacheManager，
     * 2ConcurrentMapCacheManager继承CacheManager中的getCache方法，根据名称来获取缓存组件，
     * 3如果获取为空，调用createConcurrentMapCache创建ConcurrentMapCache
     * 4缓存创建出后，程序运行会使用一个key去Cache中查找缓存内容，key默认为方法的参数
     * 5没有查取到缓存就调用目标方法，执行目标方法查询到结果，并调用put方法放进缓存
     */

    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = "emp", unless = "#a0==2")
    public Employee getEmp(Integer empId){
        System.out.println("查询"+empId+"号员工");
        Employee employee = employeeMapper.getEmpById(empId);
        return employee;
    }

    @CachePut(value = "emp",key = "#employee.empId")
    public Employee updateEmp(Employee employee){
        System.out.println("updateEmp"+employee);
        employeeMapper.updateEmp(employee);
        return employee;

    }

    @CacheEvict(value = "emp",key = "#empId", allEntries = true, beforeInvocation = true)
    public void deleteEmp(Integer empId){
        System.out.println("deleteEmp"+empId);
        //employeeMapper.deleteEmpById(empId);
    }

}
