# 🚀 部署 Firebase Cloud Function 完整指南

## 📋 已添加的简单 Function

我已经在 `functions/index.js` 中添加了最简单的 Function：

### **helloWorld Function**

```javascript
exports.helloWorld = functions.https.onRequest((req, res) => {
  res.json({
    message: 'Hello World',
    timestamp: new Date().toISOString(),
  })
})
```

**作用：** 返回 "Hello World" 消息和当前时间

---

## 🔧 部署步骤

### 方法 1: 部署单个 Function（推荐）

```bash
# 打开 CMD（不是 PowerShell）
cmd

# 进入项目目录
cd D:\Study\Monash\5032\Assignment

# 部署单个 function
firebase deploy --only functions:helloWorld
```

### 方法 2: 部署所有 Functions

```bash
# 部署所有 functions
firebase deploy --only functions
```

### 方法 3: 完整部署（包括前端）

```bash
# 部署整个项目
firebase deploy
```

---

## ⏱️ 部署时间

- **单个 Function**: 约 1-2 分钟
- **所有 Functions**: 约 2-5 分钟
- **完整项目**: 约 3-7 分钟

---

## 📊 部署过程说明

你会看到以下输出：

```
=== Deploying to 'assignment-cfc8f'...

i  deploying functions
i  functions: preparing codebase default for deployment
i  functions: ensuring required API cloudfunctions.googleapis.com is enabled...
i  functions: ensuring required API cloudbuild.googleapis.com is enabled...
i  artifactregistry: ensuring required API artifactregistry.googleapis.com is enabled...

!  functions: package.json indicates an outdated version...
   (这是警告，可以忽略)

i  functions: Loading and analyzing source code...
i  functions: preparing functions directory for uploading...
i  functions: packaged functions (XX.XX KB) for uploading

✔  functions: functions folder uploaded successfully

i  functions: updating Node.js 22 (1st Gen) function helloWorld(us-central1)...

✔  functions[helloWorld(us-central1)] Successful update operation.

Function URL (helloWorld(us-central1)):
https://us-central1-assignment-cfc8f.cloudfunctions.net/helloWorld

✔  Deploy complete!
```

---

## ✅ 验证部署

### 1. 在浏览器中访问

部署成功后，访问：

```
https://us-central1-assignment-cfc8f.cloudfunctions.net/helloWorld
```

**预期结果：**

```json
{
  "message": "Hello World",
  "timestamp": "2025-10-21T12:00:00.000Z"
}
```

### 2. 使用 curl 测试

```bash
curl https://us-central1-assignment-cfc8f.cloudfunctions.net/helloWorld
```

### 3. 在 Firebase Console 查看

1. 访问 https://console.firebase.google.com/
2. 选择项目 `assignment-cfc8f`
3. 进入 **Functions**
4. 查看 `helloWorld` function

---

## 📝 Function 基本结构

### 最简单的 HTTP Function

```javascript
exports.functionName = functions.https.onRequest((req, res) => {
  res.json({ message: 'Hello' })
})
```

### 带 CORS 的 HTTP Function

```javascript
exports.functionName = functions.https.onRequest((req, res) => {
  // 启用 CORS
  res.set('Access-Control-Allow-Origin', '*')

  res.json({ message: 'Hello' })
})
```

### Callable Function（可从前端直接调用）

```javascript
exports.functionName = functions.https.onCall((data, context) => {
  return { message: 'Hello' }
})
```

### Auth Trigger（用户注册时触发）

```javascript
exports.functionName = functions.auth.user().onCreate((user) => {
  console.log('New user:', user.email)
  return null
})
```

### Firestore Trigger（数据变化时触发）

```javascript
exports.functionName = functions.firestore.document('users/{userId}').onCreate((snap, context) => {
  const newValue = snap.data()
  console.log('New user created:', newValue)
  return null
})
```

---

## 🎯 创建新 Function 模板

### 模板 1: 简单 GET 请求

```javascript
/**
 * Description of your function
 *
 * Endpoint: GET /yourFunctionName
 * Example: https://us-central1-assignment-cfc8f.cloudfunctions.net/yourFunctionName
 */
exports.yourFunctionName = functions.https.onRequest((req, res) => {
  res.json({
    success: true,
    message: 'Your message here',
    timestamp: new Date().toISOString(),
  })
})
```

### 模板 2: 带参数的 GET 请求

```javascript
/**
 * Example: /greet?name=John
 */
exports.greet = functions.https.onRequest((req, res) => {
  const name = req.query.name || 'Guest'

  res.json({
    message: `Hello, ${name}!`,
    timestamp: new Date().toISOString(),
  })
})
```

### 模板 3: POST 请求

```javascript
/**
 * POST request handler
 */
exports.submitData = functions.https.onRequest(async (req, res) => {
  // 只接受 POST 请求
  if (req.method !== 'POST') {
    res.status(405).json({ error: 'Method not allowed' })
    return
  }

  const data = req.body

  res.json({
    success: true,
    receivedData: data,
    timestamp: new Date().toISOString(),
  })
})
```

### 模板 4: 访问 Firestore

```javascript
/**
 * Get data from Firestore
 */
exports.getData = functions.https.onRequest(async (req, res) => {
  try {
    const snapshot = await admin.firestore().collection('users').limit(10).get()

    const users = []
    snapshot.forEach((doc) => {
      users.push({
        id: doc.id,
        ...doc.data(),
      })
    })

    res.json({
      success: true,
      count: users.length,
      users: users,
    })
  } catch (error) {
    res.status(500).json({
      success: false,
      error: error.message,
    })
  }
})
```

---

## 🐛 常见问题

### Q1: 部署卡在 "Serving at port XXX"

**原因：** 这是正常的，Firebase 正在分析你的代码

**解决：** 等待 1-2 分钟，不要取消

### Q2: PowerShell 脚本执行错误

**错误信息：**

```
无法加载文件 ...firebase.ps1，因为在此系统上禁止运行脚本
```

**解决：** 使用 CMD 而不是 PowerShell

```bash
cmd /c "firebase deploy --only functions"
```

### Q3: 部署后访问 404

**可能原因：**

1. 部署还未完成（等待 1-2 分钟）
2. Function 名称错误
3. URL 错误

**检查：**

- Function URL 格式：`https://us-central1-PROJECT_ID.cloudfunctions.net/FUNCTION_NAME`
- 你的项目 ID：`assignment-cfc8f`
- Function 名称：`helloWorld`

### Q4: Function 部署后立即更新

**问题：** 修改代码后如何更新？

**步骤：**

1. 修改 `functions/index.js`
2. 保存文件
3. 重新部署：`firebase deploy --only functions:functionName`

---

## 📚 当前项目的所有 Functions

部署完成后，你的项目将有以下 Functions：

| Function 名称       | 类型         | 描述                   | URL                  |
| ------------------- | ------------ | ---------------------- | -------------------- |
| `createUserProfile` | Auth Trigger | 用户注册时自动创建档案 | (自动触发)           |
| `getUserStats`      | Callable     | 获取用户统计信息       | (前端调用)           |
| `healthCheck`       | HTTP         | 健康检查               | `/healthCheck`       |
| `apiRecipes`        | HTTP         | 获取所有菜谱           | `/apiRecipes`        |
| `apiRecipeById`     | HTTP         | 获取单个菜谱           | `/apiRecipeById/:id` |
| `apiStats`          | HTTP         | 获取统计数据           | `/apiStats`          |
| **`helloWorld`**    | **HTTP**     | **Hello World 示例**   | **`/helloWorld`**    |

---

## 🚀 快速命令参考

```bash
# 1. 部署单个 function
firebase deploy --only functions:helloWorld

# 2. 部署所有 functions
firebase deploy --only functions

# 3. 部署前端
firebase deploy --only hosting

# 4. 完整部署
firebase deploy

# 5. 查看 functions 日志
firebase functions:log

# 6. 查看特定 function 的日志
firebase functions:log --only helloWorld

# 7. 删除 function
firebase functions:delete helloWorld

# 8. 列出所有 functions
firebase functions:list
```

---

## ✨ 下一步

1. **部署 helloWorld Function**

   ```bash
   cmd /c "firebase deploy --only functions:helloWorld"
   ```

2. **等待部署完成** (约 1-2 分钟)

3. **测试访问**

   ```
   https://us-central1-assignment-cfc8f.cloudfunctions.net/helloWorld
   ```

4. **查看结果**
   ```json
   {
     "message": "Hello World",
     "timestamp": "2025-10-21T12:00:00.000Z"
   }
   ```

---

## 📞 需要帮助？

如果遇到问题：

1. **查看部署日志** - 找到错误信息
2. **检查 Firebase Console** - 查看 function 状态
3. **查看 function 日志** - `firebase functions:log`
4. **确认配置正确** - 检查 `firebase.json`

---

## 🎉 成功！

一旦你看到：

```
✔  functions[helloWorld(us-central1)] Successful update operation.
Function URL: https://us-central1-assignment-cfc8f.cloudfunctions.net/helloWorld
✔  Deploy complete!
```

你的 Function 就已经成功部署了！🚀
