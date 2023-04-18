import polyglot


@polyglot.export_value
def say_hello(input : str):
    return f"Hello, {input}, from the world of Python!"

