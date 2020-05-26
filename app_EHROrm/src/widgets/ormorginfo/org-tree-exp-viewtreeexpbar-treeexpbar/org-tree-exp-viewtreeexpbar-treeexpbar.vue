<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrgTreeExpViewtreeexpbarBase from './org-tree-exp-viewtreeexpbar-treeexpbar-base.vue';
import view_treeexpbar_tree from '@widgets/ormorginfo/ormorginfotree-treeview/ormorginfotree-treeview.vue';

 
@Component({
    components: {
        view_treeexpbar_tree, 
         
    }
})
export default class OrgTreeExpViewtreeexpbar extends OrgTreeExpViewtreeexpbarBase {

}
</script>