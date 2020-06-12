<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMLANGUAGEABILITYGRYYNLGridViewBase from './pimlanguageabilitygryynlgrid-view-base.vue';

import view_grid from '@widgets/pim-language-ability/main-language-grid/main-language-grid.vue';
import view_searchform from '@widgets/pim-language-ability/default-searchform/default-searchform.vue';

/**
 * 语言能力表格视图
 *
 * @export
 * @class PIMLANGUAGEABILITYGRYYNLGridView
 * @extends {PIMLANGUAGEABILITYGRYYNLGridViewBase}
 */
@Component({
    components: {
        view_grid, 
        view_searchform, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMLANGUAGEABILITYGRYYNLGridView extends PIMLANGUAGEABILITYGRYYNLGridViewBase { }
</script>