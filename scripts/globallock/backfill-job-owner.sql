-- 所有 Web 升级后在租户库分批执行，每批单独提交，直至影响行数为零。
-- 只解析合法 JSON 和正整数作业 ID；异常元数据保留，不猜测归属，不删除锁。
UPDATE global_lock
SET owner_id = CAST(JSON_UNQUOTE(JSON_EXTRACT(IF(JSON_VALID(handler_param), handler_param, '{}'), '$.jobId')) AS UNSIGNED)
WHERE handler IN ('auto', 'deploy') AND owner_id IS NULL
  AND JSON_UNQUOTE(JSON_EXTRACT(IF(JSON_VALID(handler_param), handler_param, '{}'), '$.jobId')) REGEXP '^[1-9][0-9]{0,18}$'
  AND CASE WHEN JSON_UNQUOTE(JSON_EXTRACT(IF(JSON_VALID(handler_param), handler_param, '{}'), '$.jobId')) REGEXP '^[1-9][0-9]{0,18}$'
      THEN CAST(JSON_UNQUOTE(JSON_EXTRACT(IF(JSON_VALID(handler_param), handler_param, '{}'), '$.jobId')) AS DECIMAL(20,0))
      ELSE NULL END <= 9223372036854775807
ORDER BY id LIMIT 1000;
