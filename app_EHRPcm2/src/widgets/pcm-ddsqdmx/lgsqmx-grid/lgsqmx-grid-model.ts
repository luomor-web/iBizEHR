/**
 * LGSQMX 部件模型
 *
 * @export
 * @class LGSQMXModel
 */
export default class LGSQMXModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof LGSQMXGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof LGSQMXGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'ormygw',
          prop: 'ormygw',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'orgsectorid',
          prop: 'orgsectorid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormpostid',
          prop: 'ormpostid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormpostname',
          prop: 'ormpostname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'pimdistirbutionid',
          prop: 'pimdistirbutionid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmddsqdmxname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmddsqdmxid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmddsqdmxid',
          dataType: 'GUID',
        },
        {
          name: 'sxrq',
          prop: 'sxrq',
          dataType: 'DATE',
        },
        {
          name: 'ormorgname',
          prop: 'ormorgname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ormorgsectorname',
          prop: 'ormorgsectorname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ormdutyid',
          prop: 'ormdutyid',
          dataType: 'PICKUP',
        },
        {
          name: 'orgid',
          prop: 'orgid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimdistirbutionname',
          prop: 'pimdistirbutionname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'orgname',
          prop: 'orgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'orgsectorname',
          prop: 'orgsectorname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'pcmddsqdid',
          prop: 'pcmddsqdid',
          dataType: 'PICKUP',
        },
        {
          name: 'pcmddsqdmx',
          prop: 'pcmddsqdmxid',
        },
      {
        name: 'n_ygbh_like',
        prop: 'n_ygbh_like',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_pimdistirbutionname_like',
        prop: 'n_pimdistirbutionname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_checkstatus_eq',
        prop: 'n_checkstatus_eq',
        dataType: 'SSCODELIST',
      },

        {
          name:'size',
          prop:'size'
        },
        {
          name:'query',
          prop:'query'
        },
        {
          name:'page',
          prop:'page'
        },
        {
          name:'sort',
          prop:'sort'
        },
        {
          name:'srfparentdata',
          prop:'srfparentdata'
        },
        // 前端新增修改标识，新增为"0",修改为"1"或未设值
        {
          name: 'srffrontuf',
          prop: 'srffrontuf',
          dataType: 'TEXT',
        },
      ]
    }
  }

}