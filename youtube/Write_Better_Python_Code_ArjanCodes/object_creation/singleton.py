'''
    Why to not write singletons:
        - Breaks OOP design principles
        - You lose controle of object creation at runtime
        - They are hard to unit test
        - They do not work well with multithread
'''


class Singleton(type):
    _instances = {}
    def __call__(cls, *args, **kwargs):
        if cls not in cls._instances:
            cls._instances[cls] = super().__call__(*args, **kwargs)
        return cls._instances[cls]

class Logger(metaclass=Singleton):
    def __init__(self):
        print("Creating Logger")

    def log(self, msg):
        print(msg)


logger = Logger()
logger2 = Logger()

print(logger)
print(logger2)

logger.log("Hello")
logger2.log("Hi")