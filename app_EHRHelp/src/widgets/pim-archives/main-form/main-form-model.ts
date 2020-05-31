/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
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
        prop: 'pimarchivesid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
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
        name: 'dabh',
        prop: 'dabh',
        dataType: 'TEXT',
      },
      {
        name: 'ormorgname3',
        prop: 'ormorgname3',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'sfxjd',
        prop: 'sfxjd',
        dataType: 'YESNO',
      },
      {
        name: 'archivescentername',
        prop: 'archivescentername',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'dabgdd',
        prop: 'dabgdd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'dabgd',
        prop: 'dabgd',
        dataType: 'TEXT',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ygbh',
        prop: 'ygbh',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'education',
        prop: 'education',
        dataType: 'SSCODELIST',
      },
      {
        name: 'dateofbirth',
        prop: 'dateofbirth',
        dataType: 'DATE',
      },
      {
        name: 'joinpartydate',
        prop: 'joinpartydate',
        dataType: 'DATE',
      },
      {
        name: 'startworkdatae',
        prop: 'startworkdatae',
        dataType: 'DATE',
      },
      {
        name: 'dastate',
        prop: 'dastate',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'fj',
        prop: 'fj',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'ormorgid3',
        prop: 'ormorgid3',
        dataType: 'PICKUP',
      },
      {
        name: 'pimarchivesid',
        prop: 'pimarchivesid',
        dataType: 'GUID',
      },
      {
        name: 'archivescenterid',
        prop: 'archivescenterid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimarchives',
        prop: 'pimarchivesid',
        dataType: 'FONTKEY',
      },
    ]
  }

}