/**
 * ZZSQDDForm 部件模型
 *
 * @export
 * @class ZZSQDDFormModel
 */
export default class ZZSQDDFormModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof ZZSQDDFormModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'pcmddsqdmxid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmddsqdmxname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'pimdistirbutionname',
        prop: 'pimdistirbutionname',
        dataType: 'PICKUPTEXT',
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
        name: 'ormyzw',
        prop: 'ormyzw',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'ormygw',
        prop: 'ormygw',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'nbzpname',
      },
      {
        name: 'ddtype',
        prop: 'ddtype',
        dataType: 'SSCODELIST',
      },
      {
        name: 'lx',
        prop: 'lx',
        dataType: 'TEXT',
      },
      {
        name: 'createdate',
        prop: 'createdate',
        dataType: 'DATETIME',
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
        name: 'ormdutyname',
        prop: 'ormdutyname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormpostname',
        prop: 'ormpostname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'orgsectorid',
        prop: 'orgsectorid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormdutyid',
        prop: 'ormdutyid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormpostid',
        prop: 'ormpostid',
        dataType: 'PICKUP',
      },
      {
        name: 'orgid',
        prop: 'orgid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimdistirbutionid',
        prop: 'pimdistirbutionid',
        dataType: 'PICKUP',
      },
      {
        name: 'pcmddsqdmxid',
        prop: 'pcmddsqdmxid',
        dataType: 'GUID',
      },
      {
        name: 'pcmddsqdmx',
        prop: 'pcmddsqdmxid',
        dataType: 'FONTKEY',
      },
    ]
  }

}