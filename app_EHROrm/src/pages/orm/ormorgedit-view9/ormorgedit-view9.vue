<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGEditView9Base from './ormorgedit-view9-base.vue';

import view_form from '@widgets/orm-org/main2-form/main2-form.vue';

/**
 * 组织管理
 *
 * @export
 * @class ORMORGEditView9
 * @extends {ORMORGEditView9Base}
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
export default class ORMORGEditView9 extends ORMORGEditView9Base { }
</script>