<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMXMGLEditViewBase from './ormxmgledit-view-base.vue';

import view_form from '@widgets/orm-xmgl/main-form/main-form.vue';

/**
 * ERP项目信息
 *
 * @export
 * @class ORMXMGLEditView
 * @extends {ORMXMGLEditViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class ORMXMGLEditView extends ORMXMGLEditViewBase { }
</script>