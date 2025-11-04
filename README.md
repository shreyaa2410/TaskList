# TaskList

# ADD 
# .env file at root directory where you need to add the SECRET_KEY=YOUR_SECRET_KEY

# First do the signup-REGISTER A USER using  
# name, email and password object in request body

# Second do the login using the same email and password used for signup 
# with email and password object in request body
# login will generate a JWT Token in response body

# use The JWT IN AUTHORIZATION HEADER WITH AUTH TYPE AS Bearer Token and add the JWT for every 
# request endpoint of the tasklist

# Endpoints
# GET all the tasks - /tasklist/task
# POST to create a task - /tasklist/task :  add  task in Request body
# GET get the task by id - /tasklist/task/id
# PUT update the task by id - /tasklist/task/id : add updated task in Request body
# DELETE delete the task by id - /tasklist/task/id
# PATCH update partially the status of the task by id - /tasklist/task/id

