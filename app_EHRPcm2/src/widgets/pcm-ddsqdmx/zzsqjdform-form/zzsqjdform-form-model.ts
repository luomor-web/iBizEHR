/**
 * ZZSQJDForm 部件模型
 *
 * @export
 * @class ZZSQJDFormModel
 */
export default class ZZSQJDFormModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof ZZSQJDFormModel
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
        name: 'ygbh',
        prop: 'ygbh',
        dataType: 'PICKUPDATA',
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
        name: 'pcmddsqdmxname',
        prop: 'pcmddsqdmxname',
        dataType: 'TEXT',
      },
      {
        name: 'createdate1',
        prop: 'createdate',
        dataType: 'DATETIME',
      },
      {
        name: 'jdkssj',
        prop: 'jdkssj',
        dataType: 'DATE',
      },
      {
        name: 'jdjssj',
        prop: 'jdjssj',
        dataType: 'DATE',
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
        name: 'lx',
        prop: 'lx',
        dataType: 'TEXT',
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