<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParLdkhqzEditViewBase from './par-ldkhqz-edit-view-base.vue';

import view_form from '@widgets/par-ldkhqz/qzfp-form/qzfp-form.vue';

/**
 * 评分权重分配
 *
 * @export
 * @class ParLdkhqzEditView
 * @extends {ParLdkhqzEditViewBase}
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
export default class ParLdkhqzEditView extends ParLdkhqzEditViewBase { }
</script>