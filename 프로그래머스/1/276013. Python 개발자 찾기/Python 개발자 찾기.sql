SELECT DI.ID, DI.EMAIL, DI.FIRST_NAME, DI.LAST_NAME
FROM DEVELOPER_INFOS AS DI
WHERE DI.SKILL_1 = 'Python' OR DI.SKILL_2 = 'Python' OR DI.SKILL_3 = 'Python'
ORDER BY DI.ID ASC