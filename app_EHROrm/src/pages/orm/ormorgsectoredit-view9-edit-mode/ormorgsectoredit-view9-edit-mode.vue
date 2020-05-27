<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGSECTOREditView9_EditModeBase from './ormorgsectoredit-view9-edit-mode-base.vue';

import view_form from '@widgets/ormorgsector/bmbzgl-form/bmbzgl-form.vue';

/**
 * 部门/项目部信息
 *
 * @export
 * @class ORMORGSECTOREditView9_EditMode
 * @extends {ORMORGSECTOREditView9_EditModeBase}
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
export default class ORMORGSECTOREditView9_EditMode extends ORMORGSECTOREditView9_EditModeBase { }
</script>