package cn.techouse.ims.repositories;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.techouse.ims.entity.ConfigValue;

@Repository
public interface ConfigValueRepository extends JpaRepository<ConfigValue, Integer>{
	/**
	 * 通过参数代码和环境代码得到所有值
	 * @param configCode
	 * @return
	 */
	public List<ConfigValue> findAllByEnvironmentCodeAndConfigCodeAndValidFlag(String environmentCode,String configCode,String validFlag);
	
	public Page<ConfigValue> findAllByEnvironmentCodeLikeAndConfigCodeLikeAndValidFlagLike(String environmentCode,String configCode,String validFlag,Pageable page);
	
}
