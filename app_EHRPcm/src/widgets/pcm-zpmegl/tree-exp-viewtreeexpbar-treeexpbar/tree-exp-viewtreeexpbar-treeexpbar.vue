<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TreeExpViewtreeexpbarBase from './tree-exp-viewtreeexpbar-treeexpbar-base.vue';
import view_treeexpbar_tree from '@widgets/pcm-zpmegl/zpmenftree-treeview/zpmenftree-treeview.vue';

 
@Component({
    components: {
        view_treeexpbar_tree, 
         
    }
})
export default class TreeExpViewtreeexpbar extends TreeExpViewtreeexpbarBase {

}
</script>