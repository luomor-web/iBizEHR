<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMXMGLGridViewBase from './ormxmglgrid-view-base.vue';

import view_grid from '@widgets/ormxmgl/main-grid/main-grid.vue';
import view_searchform from '@widgets/ormxmgl/default-searchform/default-searchform.vue';

/**
 * ERP项目信息
 *
 * @export
 * @class ORMXMGLGridView
 * @extends {ORMXMGLGridViewBase}
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
export default class ORMXMGLGridView extends ORMXMGLGridViewBase { }
</script>