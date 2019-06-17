import notebook

try:
    from collections.abc import Mapping, MutableMapping
except ImportError:
    from collections import Mapping, MutableMapping


example_notebook = 'asset/notebook/1ambda/hello_world.ipynb'

def test_render_html():
    content = notebook.read_file(example_notebook)
    parsed = notebook.parse_notebook(content)

    assert(parsed.cells[0]['cell_type'] == 'markdown')
