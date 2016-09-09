    <resultMap id="defaultResultMap" type="#MODEL_CLASS_NAME#">
        <id column="id" property="id"/>
        <result column="payload" property="payload"/>
        <result column="owner" property="owner"/>
        <result column="owner_type" property="ownerType"/>
        <result column="created_by" property="createdBy"/>
        <result column="created_time" property="createdTime"/>
        <result column="updated_by" property="updatedBy"/>
        <result column="updated_time" property="updatedTime"/>
    </resultMap>

    <sql id="*">
        <choose>
            <when test="_CountingMode_ == true">
                count('x') as id
            </when>
            <otherwise>
                id,
                payload,
                owner,
                owner_type,
                created_by,
                created_time,
                updated_by,
                updated_time
            </otherwise>
         </choose>
    </sql>

    <sql id="ORDER_BY">
        <if test="_CountingMode_ != true">order by ${options.validOrderBy} </if>
        <if test="_CountingMode_ != true and options.validOrder == 'DESC'">desc</if>
        <if test="_CountingMode_ != true and options.validOrder == 'desc'">desc</if>
        <if test="_CountingMode_ != true and options.validOrder == 'ASC'">asc</if>
        <if test="_CountingMode_ != true and options.validOrder == 'asc'">asc</if>
    </sql>

    <sql id="ORDER">
        <if test="_CountingMode_ != true and options.validOrder == 'DESC'">desc</if>
        <if test="_CountingMode_ != true and options.validOrder == 'desc'">desc</if>
        <if test="_CountingMode_ != true and options.validOrder == 'ASC'">asc</if>
        <if test="_CountingMode_ != true and options.validOrder == 'asc'">asc</if>
    </sql>

    <sql id="PAGINATION">
        <if test="_CountingMode_ != true and options.validCount != null">
            limit #{options.validCount}
        </if>
        <if test="_CountingMode_ != true and options.validStart != null">
            offset #{options.validStart}
        </if>
    </sql>

    <insert id="create"
            parameterType="#MODEL_CLASS_NAME#"
            useGeneratedKeys="true"
            keyProperty="entity.id"
            keyColumn="id">
        insert into #TABLE_NAME# (
          payload,
          owner,
          owner_type,
          created_by,
          created_time,
          updated_by,
          updated_time
        )
        values (
          #{entity.payload},
          #{entity.owner},
          #{entity.ownerType},
          #{entity.createdBy},
          #{entity.createdTime},
          #{entity.updatedBy},
          #{entity.updatedTime}
        )
    </insert>

    <select id="get" resultMap="defaultResultMap">
        select
            <include refid="*"/>
        from #TABLE_NAME#
        where id = #{id}
            and deleted=false
    </select>


    <update id="update" parameterType="#MODEL_CLASS_NAME#">
        update #TABLE_NAME#
        set
          payload = #{entity.payload},
          owner = #{entity.owner},
          owner_type = #{entity.ownerType},
          updated_by = #{entity.updatedBy},
          updated_time = #{entity.updatedTime}
        where
          id = #{id}
    </update>

    <delete id="delete">
       delete from #TABLE_NAME#
         where id = #{id}
    </delete>
