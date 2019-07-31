package webSocket.service;

import java.util.List;

public interface ISessionService {
    /**
     * 通过部门id推送消息
     * @param orgId
     * @param message
     */
    public void sentMessageByOrgId(String orgId, String message);

    /**
     * 向多个部门id推送消息
     * @param userId
     * @param message
     */
    public void sentMessageByOrgIds(List<String> userId, String message);

    /**
     * 根据部门id和用户id推送消息
     * @param orgId
     * @param message
     */
    public void sentMessageByOrgIdAndUserId(String orgId, String userId, String message);

    /**
     * 根据部门id和用户id组推送消息
     * @param orgId
     * @param message
     */
    public void sentMessageByOrgIdAndUserIds(String orgId, List<String> userId, String message);

    public void sentMeassgeByIJudgeAndMessage(IJudgeAndMessage judgeAndMessage);
}
