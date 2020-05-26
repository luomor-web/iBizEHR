<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGSECTORXMBBZGLEditViewBase from './ormorgsectorxmbbzgledit-view-base.vue';

import view_form from '@widgets/ormorgsector/xmbbzgl-form/xmbbzgl-form.vue';

/**
 * 项目部管理
 *
 * @export
 * @class ORMORGSECTORXMBBZGLEditView
 * @extends {ORMORGSECTORXMBBZGLEditViewBase}
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
export default class ORMORGSECTORXMBBZGLEditView extends ORMORGSECTORXMBBZGLEditViewBase { }
</script>