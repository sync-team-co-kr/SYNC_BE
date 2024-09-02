package project.service.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import project.service.TaskService;
import project.service.dto.request.GetTaskRequestDto;
import project.service.global.SuccessResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TaskController {
    private final TaskService taskService;
    @GetMapping("/api/task/v1")
    public SuccessResponse getOnlyChildrenTasks(@RequestParam Long taskId)  {
        //progress 로직 추가
        return taskService.getOnlyChildrenTasks(taskId);
    }
    @GetMapping("/api/task/v2")
    public SuccessResponse getTasksByProjectId(@RequestParam Long projectId)  {
        return taskService.getTaskByProjectId(projectId);
    }
    @GetMapping("/project/task/api/v1/users")
    public SuccessResponse getUserFromTask(@RequestParam Long taskId) {
        return taskService.getUserIdsFromTask(taskId);
    }
    //jwtTEST
    @GetMapping("/user/api/test")
    public void projectAPITest() {
        log.info("projectAPITest");
    }
    @GetMapping("/api/task/v3")
    public SuccessResponse getTask(@RequestParam Long taskId) {
        return taskService.getTask(taskId);
    }
    @GetMapping("/api/task/image")
    public ResponseEntity<Resource> getImage(@RequestParam String filename) {
        return taskService.getImage(filename);
    }
}
