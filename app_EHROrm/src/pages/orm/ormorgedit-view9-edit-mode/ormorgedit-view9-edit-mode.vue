<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGEditView9_EditModeBase from './ormorgedit-view9-edit-mode-base.vue';

import view_form from '@widgets/ormorg/main-form/main-form.vue';

/**
 * 组织信息
 *
 * @export
 * @class ORMORGEditView9_EditMode
 * @extends {ORMORGEditView9_EditModeBase}
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
export default class ORMORGEditView9_EditMode extends ORMORGEditView9_EditModeBase { }
</script>