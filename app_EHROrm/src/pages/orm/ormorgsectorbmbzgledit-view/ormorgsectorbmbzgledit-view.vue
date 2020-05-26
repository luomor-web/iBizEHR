<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGSECTORBMBZGLEditViewBase from './ormorgsectorbmbzgledit-view-base.vue';

import view_form from '@widgets/ormorgsector/bmbzgl-form/bmbzgl-form.vue';

/**
 * 部门管理
 *
 * @export
 * @class ORMORGSECTORBMBZGLEditView
 * @extends {ORMORGSECTORBMBZGLEditViewBase}
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
export default class ORMORGSECTORBMBZGLEditView extends ORMORGSECTORBMBZGLEditViewBase { }
</script>