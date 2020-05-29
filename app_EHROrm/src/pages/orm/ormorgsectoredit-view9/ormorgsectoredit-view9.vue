<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGSECTOREditView9Base from './ormorgsectoredit-view9-base.vue';

import view_form from '@widgets/orm-orgsector/main2-form/main2-form.vue';

/**
 * 部门/项目部管理
 *
 * @export
 * @class ORMORGSECTOREditView9
 * @extends {ORMORGSECTOREditView9Base}
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
export default class ORMORGSECTOREditView9 extends ORMORGSECTOREditView9Base { }
</script>