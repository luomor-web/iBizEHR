<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGEditViewBase from './ormorgedit-view-base.vue';

import view_form from '@widgets/ormorg/main-form/main-form.vue';

/**
 * 组织管理
 *
 * @export
 * @class ORMORGEditView
 * @extends {ORMORGEditViewBase}
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
export default class ORMORGEditView extends ORMORGEditViewBase { }
</script>